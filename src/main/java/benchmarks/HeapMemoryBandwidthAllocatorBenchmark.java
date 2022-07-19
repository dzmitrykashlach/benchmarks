package benchmarks;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class HeapMemoryBandwidthAllocatorBenchmark {
    @Param({"5000000","10000000","20000000"})
    private int size;

    @Benchmark
    @Measurement(iterations = 3)
    @BenchmarkMode(Mode.AverageTime)
    public void check() {
        for (int i = 0; i < size; i++) {
            BigCharArray bigCharArray = new BigCharArray();
            bigCharArray.getInternals();
        }
    }
}
