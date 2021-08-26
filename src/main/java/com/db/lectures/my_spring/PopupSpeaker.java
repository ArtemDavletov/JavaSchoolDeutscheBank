package com.db.lectures.my_spring;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
