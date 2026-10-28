package com.dinara.studentapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @Test
    void nameIsStored() {
        Student s = new Student();
        s.setName("Dinara Djaylauva");
        assertEquals("Dinara Djaylauva", s.getName());
    }
}
