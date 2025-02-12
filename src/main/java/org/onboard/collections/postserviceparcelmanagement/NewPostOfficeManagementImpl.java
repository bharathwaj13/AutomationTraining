package org.onboard.collections.postserviceparcelmanagement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import java.util.*;

public class NewPostOfficeManagementImpl implements NewPostOfficeManagement {
    private List<Box> boxes;

    public NewPostOfficeManagementImpl(List<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException("Boxes list cannot be null");
        }
        this.boxes = boxes;
    }

    @Override
    public Optional<Box> getBoxById(int id) {

        for(Box eachBox:boxes){
            if(eachBox.getId()==id)
                return Optional.of(eachBox);
        }
        return Optional.empty();
        /*boxes.sort(Comparator.comparingInt(Box::getId));
        int index = Collections.binarySearch(boxes, new Box("", "", 0, 0, 0, "", ""),
                Comparator.comparingInt(Box::getId));
        if (index >= 0) {
            return Optional.of(boxes.get(index));
        } else {
            return Optional.empty();
        }*/
    }

    @Override
    public String getDescSortedBoxesByWeight() {
        boxes.sort(Comparator.comparingDouble(Box::getWeight));
        StringBuilder result = new StringBuilder();
        for (Box box : boxes) {
            result.append(box.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getAscSortedBoxesByCost() {
        boxes.sort(Comparator.comparingDouble(Box::getCost));
        StringBuilder result = new StringBuilder();
        for (Box box : boxes) {
            result.append(box.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public List<Box> getBoxesByRecipient(String recipient) {
        if (recipient == null) {
            throw new NullPointerException("Recipient cannot be null");
        }

        List<Box> result = new ArrayList<>();
        for(Box eachBox:boxes){
            if(eachBox.getRecipient().equalsIgnoreCase(recipient))
                result.add(eachBox);
        }
        return result;
    }
}

