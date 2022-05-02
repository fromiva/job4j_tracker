package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 4", 34),
                new Attachment("image 3", 13)
        );

        Comparator<Attachment> intComparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };

        attachments.sort(intComparator);
        System.out.println(attachments);

        Comparator<Attachment> stringComparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };

        attachments.sort(stringComparator);
        System.out.println(attachments);
    }
}
