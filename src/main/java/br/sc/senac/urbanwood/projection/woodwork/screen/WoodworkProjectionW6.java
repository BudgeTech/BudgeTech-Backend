package br.sc.senac.urbanwood.projection.woodwork.screen;

import br.sc.senac.urbanwood.projection.woodwork.WoodworkProjection;

public interface WoodworkProjectionW6 {

    String getCompanyName();

    String getCnpj();

    ImageProjection getImageModel();

    interface ImageProjection {

        byte[] getPicByte();
    }
}
