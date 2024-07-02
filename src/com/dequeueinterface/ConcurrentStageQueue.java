package com.dequeueinterface;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentStageQueue
{
   ConcurrentLinkedDeque<Item> queue = new ConcurrentLinkedDeque<>();

    public void addItem(Item item) 
    {
        queue.addLast(item);
    }

    public Item getNextItem() 
    {
        return queue.pollFirst();
    }
}
