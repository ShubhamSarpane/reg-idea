package com.Ideation.entity;

import java.util.ArrayList;
import java.util.List;

public class Idealist {
	
	private List<Idea> ideas;

    public Idealist() {
        ideas = new ArrayList<>();
	
    }

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
    
    
	

}
