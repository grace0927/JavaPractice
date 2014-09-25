/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetCode;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author jianyu
 */
public class Observer  implements PropertyChangeListener {
    public Observer(RegisterStatus model) {
        model.addChangeListener(this);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("Extension " + event.getPropertyName() + " From "
                + event.getOldValue() + " to " + event.getNewValue());
    }
}