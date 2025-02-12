package org.onboard.collections.poststorageservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {

    private List<Box> storage;

    public NewPostOfficeStorageImpl() {
        this.storage = new ArrayList<>();
    }

    @Override
    public boolean acceptBox(Box box) {
        return storage.add(box);
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException("Collection cannot be null");
        }

        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException("Box cannot be null");
            }
        }
        return storage.addAll(boxes);
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException("Collection cannot be null");
        }

        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException("Box cannot be null");
            }
        }

        return storage.removeAll(boxes);
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate cannot be null");
        }

        List<Box> removedBoxes = new ArrayList<>();
        Iterator<Box> iterator = storage.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (predicate.test(box)) {
                iterator.remove();
                removedBoxes.add(box);
            }
        }

        return removedBoxes;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        List<Box> result = new ArrayList<>();
        for (Box box : storage) {
            if (box.getWeight() < weight) {
                result.add(box);
            }
        }
        return result;
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        if (cost == null) {
            throw new NullPointerException("Cost cannot be null");
        }

        List<Box> result = new ArrayList<>();
        for (Box box : storage) {
            if (box.getCost().compareTo(cost) > 0) {
                result.add(box);
            }
        }
        return result;
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        List<Box> result = new ArrayList<>();
        for (Box box : storage) {
            if (box.getVolume() >= volume) {
                result.add(box);
            }
        }
        return result;
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate cannot be null");
        }

        List<Box> result = new ArrayList<>();
        for (Box box : storage) {
            if (predicate.test(box)) {
                result.add(box);
            }
        }
        return result;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if (predicate == null) {
            throw new NullPointerException("Predicate cannot be null");
        }

        for (Box box : storage) {
            if (predicate.test(box)) {
                box.setOffice(newOfficeNumber);
            }
        }
    }

    public List<Box> getStorage() {
        return storage;
    }
}
