package benchmarks;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner{

    public static void main(String[] args) throws RunnerException {
        String use="-XX:+Use";
        int forks = 1;
        int warmUpOperations = 2;
        final Options g1gcOptions = new OptionsBuilder()
                .include(HeapMemoryBandwidthAllocatorBenchmark.class.getSimpleName())
                .forks(forks)
                .warmupIterations(warmUpOperations)
                .jvmArgs(use+"G1GC")
                .build();
        final Options shenandoahgcOptions = new OptionsBuilder()
                .include(HeapMemoryBandwidthAllocatorBenchmark.class.getSimpleName())
                .forks(forks)
                .warmupIterations(warmUpOperations)
                .jvmArgs(use+"ShenandoahGC")
                .build();
        new Runner(g1gcOptions).run();
        new Runner(shenandoahgcOptions).run();
    }
}
