package com.company.items.scrolls;

import com.company.items.Item;

public abstract class Scroll extends Item {
        private int percentageBuff;

    public Scroll(String name, int percentageBuff) {
        super(name);
        this.percentageBuff = percentageBuff;
    }
}

