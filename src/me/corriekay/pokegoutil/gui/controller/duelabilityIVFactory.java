package me.corriekay.pokegoutil.gui.controller;

import javafx.beans.property.Property;
import javafx.scene.control.TableColumn;
import me.corriekay.pokegoutil.data.models.PokemonModel;

public class duelabilityIVFactory implements columsFactory{
    @Override
    public void setValue(TableColumn<PokemonModel, Property> col) {
        col.setCellValueFactory(cellData -> (Property) cellData.getValue().duelAbilityIvProperty());
    }
}
