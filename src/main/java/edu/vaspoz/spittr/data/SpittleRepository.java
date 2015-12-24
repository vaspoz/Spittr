package edu.vaspoz.spittr.data;

import edu.vaspoz.spittr.Spittle;

import java.util.List;

/**
 * Created by Vasilii_Pozdeev on 24-Dec-15.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);
    Spittle save(Spittle spittle);
}