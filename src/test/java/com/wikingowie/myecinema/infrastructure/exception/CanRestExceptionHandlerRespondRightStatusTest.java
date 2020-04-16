package com.wikingowie.myecinema.infrastructure.exception;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.wikingowie.myecinema.domain.booking.BookingNotFoundException;
import com.wikingowie.myecinema.infrastructure.email.exception.EmailServiceException;
import com.wikingowie.myecinema.infrastructure.exception.ErrorModel.ApiError;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

import javax.mail.MessagingException;
import javax.servlet.ServletException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CanRestExceptionHandlerRespondRightStatusTest {

    Exception ex;
    ResponseEntity<ApiError> apiError;
    ResponseEntity<Object> apiObjectError;
    RestExceptionHandler handler = new RestExceptionHandler();


    //NOT FOUND EXCEPTIONS
    @Test
    public void UsernameNotFoundExceptionRespondTest(){
        //given
        ex = mock(UsernameNotFoundException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleNotFoundException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void EntityNotFoundExceptionRespondTest(){
        //given
        ex = mock(EntityNotFoundException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleNotFoundException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void BookingNotFoundExceptionRespondTest(){
        //given
        ex = mock(BookingNotFoundException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleNotFoundException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    //EXCEPTION
    @Test
    public void GeoIp2ExceptionRespondTest(){
        //given
        ex = mock(GeoIp2Exception.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void EmailServiceExceptionRespondTest(){
        //given
        ex = mock(EmailServiceException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void ServletExceptionRespondTest(){
        //given
        ex = mock(ServletException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void IOExceptionRespondTest(){
        //given
        ex = mock(IOException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void IllegalArgumentExceptionRespondTest(){
        //given
        ex = mock(IllegalArgumentException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void RuntimeExceptionRespondTest(){
        //given
        ex = mock(RuntimeException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    @Test
    public void ExceptionRespondTest(){
        //given
        ex = mock(Exception.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    //MESSAGING EXCEPTION
    @Test
    public void MessagingExceptionRespondTest(){
        //given
        ex = mock(MessagingException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    //THROWABLE
    @Test
    public void ThrowableRespondTest(){
        //given
        Throwable ex = mock(Throwable.class);

        //when
        apiError = handler.handleException(ex);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, apiError.getStatusCode() );
        assertEquals("Unexpected error has occurred.", apiError.getBody().getMessage() );
    }

    //ACCESS DENIED EXCEPTION
    @Test
    public void AccessDeniedExceptionRespondTest(){
        //given
        ex = mock(AccessDeniedException.class);

        //when
        apiError = handler.handleAccessDeniedException(ex);

        //then
        assertEquals(HttpStatus.FORBIDDEN, apiError.getStatusCode() );
        assertEquals("Access Denied: "+ ex.getMessage(), apiError.getBody().getMessage() );
    }

    //AUTHENTICATION EXCEPTION
    @Test
    public void AuthenticationExceptionRespondTest(){
        //given
        ex = mock( AuthenticationException.class);
        when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiError = handler.handleAuthenticationException(ex);

        //then
        assertEquals(HttpStatus.UNAUTHORIZED, apiError.getStatusCode() );
        assertEquals("mockMessage", apiError.getBody().getMessage() );
    }

    //Overriden
    @Test
    public void HttpMessageNotReadableExceptionRespondTest(){
        //given
        HttpMessageNotReadableException ex = mock( HttpMessageNotReadableException.class);
        HttpHeaders headers = mock( HttpHeaders.class);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        WebRequest request = mock( WebRequest.class);

       // when(ex.getMessage()).thenReturn("mockMessage");

        //when
        apiObjectError = handler.handleHttpMessageNotReadable(ex, headers, status, request);

        //then
        assertEquals(HttpStatus.BAD_REQUEST, apiObjectError.getStatusCode() );

    }

  //  handleMethodArgumentNotValid

    @Test
    public void MissingServletRequestParameterExceptionRespondTest(){
        //given
        MissingServletRequestParameterException ex = mock( MissingServletRequestParameterException.class);
        HttpHeaders headers = mock( HttpHeaders.class);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        WebRequest request = mock( WebRequest.class);

        //when
        apiObjectError = handler.handleMissingServletRequestParameter(ex, headers, status, request);

        //then
        assertEquals(HttpStatus.BAD_REQUEST, apiObjectError.getStatusCode() );

    }




}
