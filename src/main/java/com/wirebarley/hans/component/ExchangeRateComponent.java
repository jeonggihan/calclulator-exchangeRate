package com.wirebarley.hans.component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;

@Component
public class ExchangeRateComponent {

    private static Map< String, BigDecimal > exchangeRateList;
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure( JsonParser.Feature.ALLOW_COMMENTS, true );
        OBJECT_MAPPER.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
        OBJECT_MAPPER.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
        OBJECT_MAPPER.configure( MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true );
    }

    @Value( "${apilayer.url}" )
    private String apilayerUrl;

    @Value( "${apilayer.accessKey}" )
    private String accessKey;

    /**
     * 빈 생성시 한번 호출
     */
    @PostConstruct
    private void init () {
        exchangeRateList = getExchangeList();
    }

    /**
     * 30분 마다 갱신
     */
    @Scheduled(fixedDelay = 1800000)
    public void refresh() {

        Map< String, BigDecimal > map = getExchangeList();
        if ( map != null ) {
            exchangeRateList = map;
        }

    }

    /**
     * 환율 가져오기
     *
     * @param target
     * @return
     */
    public BigDecimal getExchangeRate ( String target ) {
        return exchangeRateList.get( "USD" + target );
    }

    /**
     * 환율 리스트 호출
     *
     * @return 환율 리스트
     */
    private Map< String, BigDecimal > getExchangeList() {
        Map< String, Object > param = new HashMap<>(  );
        param.put( "access_key", accessKey );

        ExchangeRateResult result = this.send( "/live", param, ExchangeRateResult.class );
        if ( result != null ) {
            return result.getQuotes();
        }
        return null;
    }

    /**
     * api 호춣
     *
     * @param path URI
     * @param httpParams 파라미터
     * @param resultType 결과 리턴 유형
     * @return 결과값
     */
    private < T extends ExchangeRateResult > T send ( String path, Map< String, Object > httpParams, Class< T > resultType ) {

        // 응답 처리
        try {

            StringBuilder url = new StringBuilder( apilayerUrl + path );

            for( Entry< String, Object > entry : httpParams.entrySet() ) {
                if ( url.indexOf( "?" ) < 0 ) {
                    url.append( "?" );
                }
                url.append( entry.getKey() ).append( "=" ).append( entry.getValue() ).append( "&" );
            }

            // API 호출
            String responseJson = new RestTemplate().getForObject( new URI( url.toString() ), String.class );
            T result = OBJECT_MAPPER.readValue( responseJson, resultType );
            return result;

        } catch ( Exception e ) {
            return null;
        }
    }

}
