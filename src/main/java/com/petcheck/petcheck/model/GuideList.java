package com.petcheck.petcheck.model;

        import com.petcheck.petcheck.model.Guides.Guide;

        import java.util.LinkedList;

public class GuideList {
    public LinkedList<Guide> guidelist = new LinkedList<>();


    public void addGuide(Guide guide) {
        guidelist.add(guide);


    }

    public void displaylist() {
        for (Guide list : guidelist) {
            System.out.println(list.getName());
        }
    }
}