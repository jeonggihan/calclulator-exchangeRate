
(function ( $ ) {

    // 환율 정보 선택시
    $( '#localeSelect' ).on( 'change', function () {
        var selectValue = this.value;
        if ( selectValue !== '' ) {
            apiCall( '/exchangeRate', { target : selectValue } )
                .then( function ( data ) {
                    $( '.exchangeRate' ).text( data + ' ' + selectValue + '/USD' );
                } )
                .fail( function ( object ) {
                    alert( object.msg );
                } );
        }
    } );

    // 발송금액 입력 콤마 처리
    $( '#sendPrice' ).on( 'keyup', function () {
        this.value = comma( uncomma( this.value ) );
    } );

    $( '#calculator' ).on( 'click', function () {
        apiCall( '/calculator', {
                target : $( '#localeSelect' ).val(),
                value : uncomma( $( '#sendPrice' ).val() )
            } )
            .then( function ( data ) {
                $( '#result' ).text( data.amountReceived + ' ' + data.currencyType );
                $( '.result' ).show();
            } )
            .fail( function ( object ) {
                alert( object.msg );
            } );
    } );

    /**
     * 화면 입력 콤마 처리
     * @param str
     * @returns {string}
     */
    function comma ( str ) {
        str = String( str );
        return str.replace( /(\d)(?=(?:\d{3})+(?!\d))/g, "$1," );
    }

    /**
     * 콤마 제거 처리
     *
     * @param str
     * @returns {string}
     */
    function uncomma ( str ) {
        str = String( str );
        return str.replace( /[^\d\.]+/g, "" );
    }


    /**
     * api 호출
     *
     * @param url
     * @param params
     * @returns {*}
     */
    function apiCall ( url, params ) {

        var instence = this,
            promise  = $.Deferred(),
            options  = {
                url   : url,
                data  : params,
                method: "POST"
            };

        $.ajax( options )
            .done( function ( result ) {
                if ( result.code === 200 ) promise.resolve( result.data );
                else promise.reject( result );
            } )
            .fail( function ( xhr ) {
                promise.reject( xhr );
            } );
        return promise;
    }

})( $ );