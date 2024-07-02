package com.dequeueinterface;

public class Item implements Comparable<Item>
{
    private String itemId;
    private int stage;
    private  int priority;
    private String description;

    public Item(String itemId, int stage, int priority, String description) 
    {
        this.itemId = itemId;
        this.stage = stage;
        this.priority = priority;
        this.description = description;
    }

    public String getItemId() 
    {
        return itemId;
    }

    public int getStage()
    {
        return stage;
    }

    public void setStage(int stage) 
    {
        this.stage = stage;
    }

    public int getPriority()
    {
        return priority;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public int compareTo(Item other) 
    {
        return Integer.compare(this.priority, other.priority);
    }

	@Override
	public String toString()
	{
		return "Item [itemId=" + itemId + ", stage=" + stage + ", priority=" + priority + ", description=" + description
				+ "]";
	}
}



