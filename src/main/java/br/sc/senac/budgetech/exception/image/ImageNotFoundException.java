package br.sc.senac.budgetech.exception.image;

public class ImageNotFoundException extends RuntimeException{

    public ImageNotFoundException(String message) {
        super(message);
    }
}
