package com.mycompany.common.function;

import com.mycompany.common.Error;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Objects;

/**
 * Created by antongusev on 19.11.16.
 */
@Component
public class ResponseProcessor{

    public void apply(Object result, Object exception, DeferredResult deferredResult) {
        if (Objects.isNull(exception))
            deferredResult.setResult(ResponseEntity.status(HttpStatus.OK).body(result));
        else if (((Throwable) exception).getCause() instanceof HystrixRuntimeException)
            deferredResult.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Error(100, "bad request")));
    }

}
