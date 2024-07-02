package com.dequeueinterface;
import java.util.ArrayDeque;

public class SimpleStageQueue
{
    private  ArrayDeque<Item> queue = new ArrayDeque<>();

    public void addItem(Item item) 
    {
        queue.addLast(item);
    }

    public Item getNextItem() 
    {
        return queue.pollFirst();
    }
}


