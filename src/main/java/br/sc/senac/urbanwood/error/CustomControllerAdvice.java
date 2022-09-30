package br.sc.senac.urbanwood.error;

import br.sc.senac.urbanwood.exception.address.AddressInvalidException;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.exception.address.AddressStreetAndNumberRegisteredException;
import br.sc.senac.urbanwood.exception.client.ClientCpfInvalidException;
import br.sc.senac.urbanwood.exception.client.ClientCpfRegisteredException;
import br.sc.senac.urbanwood.exception.client.ClientLoginRegisteredException;
import br.sc.senac.urbanwood.exception.client.ClientNotFoundException;
import br.sc.senac.urbanwood.exception.color.ColorNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactEmailInvalidException;
import br.sc.senac.urbanwood.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactPhoneNumberRegisteredException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureInvalidException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.urbanwood.exception.item.ItemInvalidException;
import br.sc.senac.urbanwood.exception.item.ItemNotFoundException;
import br.sc.senac.urbanwood.exception.living_area.LivingAreaNotFoundException;
import br.sc.senac.urbanwood.exception.order.OrderInvalidException;
import br.sc.senac.urbanwood.exception.order.OrderNotFoundException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjInvalidException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkLoginRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomControllerAdvice {

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAddressNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(AddressStreetAndNumberRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleAddressRoadAndNumberRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(AddressInvalidException.class)
    public ResponseEntity<ErrorResponse> handleAddressInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ClientCpfRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleClientCpfRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(ClientCpfInvalidException.class)
    public ResponseEntity<ErrorResponse> handleClientCpfInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ClientLoginRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleClientLoginInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ColorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleColorNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ContactEmailRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactEmailRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(ContactEmailInvalidException.class)
    public ResponseEntity<ErrorResponse> handleContactEmailInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContactNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ContactPhoneNumberRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactPhoneNumberRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(FurnitureNameRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureNameRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(FurnitureNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(FurnitureInvalidException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ItemInvalidException.class)
    public ResponseEntity<ErrorResponse> handleItemInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(LivingAreaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLivingAreaNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(OrderInvalidException.class)
    public ResponseEntity<ErrorResponse> handleOrderInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(WoodworkCnpjRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkCnpjRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }


    @ExceptionHandler(WoodworkCnpjInvalidException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkCnpjInvalidException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(WoodworkLoginRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkLoginRegisteredException(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(WoodworkNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
