package br.sc.senac.urbanwood.projection.woodwork.filter;

import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

public interface WoodworkProjectionFilter {

    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
