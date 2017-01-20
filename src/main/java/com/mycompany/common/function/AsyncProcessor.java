package com.mycompany.common.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by antongusev on 06.12.16.
 */
@Component
public class AsyncProcessor {

    @Autowired
    private ResponseProcessor responseProcessor;

    @Autowired
    private Executor executor;

    public DeferredResult supply(Supplier supplier) {
        final DeferredResult deferredResult = new DeferredResult();
        CompletableFuture.supplyAsync(supplier, executor)
                .whenCompleteAsync((result,  exception) ->
                        responseProcessor.apply(result, exception, deferredResult), executor);
        return deferredResult;
    }

    public DeferredResult runAsync(Runnable runnable) {
        final DeferredResult deferredResult = new DeferredResult();
        CompletableFuture.runAsync(runnable, executor)
                .whenCompleteAsync((result,  exception) ->
                        responseProcessor.apply(result, exception, deferredResult), executor);
        return deferredResult;
    }

    public DeferredResult supplyThenAccept(Supplier supplier, Consumer consumer) {
        final DeferredResult deferredResult = new DeferredResult();
        CompletableFuture.supplyAsync(supplier, executor).thenAcceptAsync(consumer)
                .whenCompleteAsync((result,  exception) ->
                        responseProcessor.apply(result, exception, deferredResult), executor);
        return deferredResult;
    }

}
