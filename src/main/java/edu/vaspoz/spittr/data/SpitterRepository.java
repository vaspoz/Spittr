package edu.vaspoz.spittr.data;

import edu.vaspoz.spittr.Spitter;

/**
 * Created by Vasilii_Pozdeev on 24-Dec-15.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
