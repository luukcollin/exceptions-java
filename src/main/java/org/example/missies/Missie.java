package org.example.missies;

public abstract class Missie {
    final int DEVELOPER_STRAFPUNTEN = -100;
    final int TE_BEHALEN_PUNTEN = 3;
    int behaaldePunten = 0;
    abstract int voerUit(boolean sloper);

    void setPunten(boolean behaald){
        behaaldePunten = behaald ? TE_BEHALEN_PUNTEN : 0;
    }
}
