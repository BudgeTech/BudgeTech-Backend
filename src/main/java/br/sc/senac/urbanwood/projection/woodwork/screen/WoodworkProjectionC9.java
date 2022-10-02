package br.sc.senac.urbanwood.projection.woodwork.screen;

import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

public interface WoodworkProjectionC9 {

    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
