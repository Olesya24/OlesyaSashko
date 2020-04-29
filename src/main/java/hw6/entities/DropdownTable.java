package hw6.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class DropdownTable {
    private String dropdownValue;

    public DropdownTable(String dropdownValue){
        this.dropdownValue = dropdownValue;
    }
    public String getDropdownValue () {
        return dropdownValue;
    }
}
