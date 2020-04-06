package quick.pager.shop.auth.feign.strategy;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import java.util.concurrent.Callable;
import org.springframework.stereotype.Component;

/**
 * 熔断策略
 *
 * @author siguiyang
 */
@Component
public class AuthHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    /**
     * Instantiates a new Custom hystrix concurrency strategy.
     */
    public AuthHystrixConcurrencyStrategy() {
        HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
    }

    /**
     * Wrap callable callable.
     *
     * @param <T>      the type parameter
     * @param callable the callable
     * @return the callable
     */
    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new HystrixContextWrapper<T>(callable);
    }

    /**
     * The class Hystrix context wrapper.
     *
     * @param <V> the type parameter
     */
    public static class HystrixContextWrapper<V> implements Callable<V> {

        private HystrixRequestContext hystrixRequestContext;
        private Callable<V> delegate;

        /**
         * Instantiates a new Hystrix context wrapper.
         *
         * @param delegate the delegate
         */
        HystrixContextWrapper(Callable<V> delegate) {
            this.hystrixRequestContext = HystrixRequestContext.getContextForCurrentThread();
            this.delegate = delegate;
        }

        /**
         * Call v.
         *
         * @return the v
         * @throws Exception the exception
         */
        @Override
        public V call() throws Exception {
            HystrixRequestContext existingState = HystrixRequestContext.getContextForCurrentThread();
            try {
                HystrixRequestContext.setContextOnCurrentThread(this.hystrixRequestContext);
                return this.delegate.call();
            } finally {
                HystrixRequestContext.setContextOnCurrentThread(existingState);
            }
        }
    }
}
