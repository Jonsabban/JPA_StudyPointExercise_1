/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Sanox
 */
public class Control {

    public static void main(String[] args) {

        HashMap puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("SP_JPA1", puproperties);

        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("SP_JPA1", puproperties);

    }
}
