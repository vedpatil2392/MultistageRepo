package com.dequeueinterface;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

public class MultiStageProcessing 
{
    private int stages;
    private  ExecutorService executor;

    public MultiStageProcessing(int stages, int threads) 
    {
        this.stages = stages;
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public void processItems(StageQueue[] stageQueues)
    {
        for (int i = 0; i < stages; i++) 
        {
            final int stage = i;
            executor.submit(() ->
            {
                while (true)
                {
                    Item item = stageQueues[stage].getNextItem();
                    if (item != null) 
                    {
                        System.out.println("Processing item: " + item.getItemId() + " at stage: " + stage);
                        item.setStage(stage + 1);
                        if (stage + 1 < stages)
                        {
                            stageQueues[stage + 1].addItem(item);
                        }
                    }
                }
            });
        }
    }

    public void shutdown()
    {
        executor.shutdown();
    }

    public static void main(String[] args)
    {
        int stages = 3;
        int threads = 3;
        MultiStageProcessing msp = new MultiStageProcessing(stages, threads);

        StageQueue[] stageQueues = new StageQueue[stages];
        for (int i = 0; i < stages; i++)
        {
            stageQueues[i] = new StageQueue();
        }

        // Adding sample items
        for (int i = 0; i < 10; i++) 
        {
            stageQueues[0].addItem(new Item("Item" + i, 0, (int) (Math.random() * 10), "Description" + i));
        }

        msp.processItems(stageQueues);
        
        // Let it run for a while
        try
        {
            Thread.sleep(10000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        msp.shutdown();
    }
}


