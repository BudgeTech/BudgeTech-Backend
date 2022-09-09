package br.sc.senac.budgetech.backend.error;

import br.sc.senac.budgetech.backend.exception.address.AddressInvalidException;
import br.sc.senac.budgetech.backend.exception.address.AddressNotFoundException;
import br.sc.senac.budgetech.backend.exception.address.AddressStreetAndNumberRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfInvalidException;
import br.sc.senac.budgetech.backend.exception.client.ClientCpfRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientLoginRegisteredException;
import br.sc.senac.budgetech.backend.exception.client.ClientNotFoundException;
import br.sc.senac.budgetech.backend.exception.color.ColorNotFoundException;
import br.sc.senac.budgetech.backend.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.budgetech.backend.exception.contact.ContactNotFoundException;
import br.sc.senac.budgetech.backend.exception.contact.ContactPhoneNumberRegisteredException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureInvalidException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.budgetech.backend.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.budgetech.backend.exception.item.ItemInvalidException;
import br.sc.senac.budgetech.backend.exception.item.ItemNotFoundException;
import br.sc.senac.budgetech.backend.exception.livingarea.LivingAreaNotFoundException;
import br.sc.senac.budgetech.backend.exception.request.RequestInvalidException;
import br.sc.senac.budgetech.backend.exception.request.RequestNotFoundException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkLoginRegisteredException;
import br.sc.senac.budgetech.backend.exception.woodwork.WoodworkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomControllerAdvice {

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAddressNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(AddressStreetAndNumberRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleAddressRoadAndNumberRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(AddressInvalidException.class)
    public ResponseEntity<ErrorResponse> handleAddressInvalidExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ClientCpfRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleClientCpfRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(ClientCpfInvalidException.class)
    public ResponseEntity<ErrorResponse> handleClientCpfInvalidExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ClientLoginRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleClientLoginInvalidExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ColorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleColorNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ContactEmailRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactEmailRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContactNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ContactPhoneNumberRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactPhoneNumberRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(FurnitureNameRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureNameRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(FurnitureNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(FurnitureInvalidException.class)
    public ResponseEntity<ErrorResponse> handleFurnitureInvalidExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(ItemInvalidException.class)
    public ResponseEntity<ErrorResponse> handleItemInvalidExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(LivingAreaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLivingAreaNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(RequestNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRequestNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(RequestInvalidException.class)
    public ResponseEntity<ErrorResponse> handleRequestInvalidExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(WoodworkCnpjRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkCnpjRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(WoodworkLoginRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkLoginRegisteredExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(WoodworkNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleWoodworkNotFoundExceptions(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
