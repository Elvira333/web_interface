/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.Error;
import org.openapitools.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-19T12:57:30.274029200+03:00[Europe/Moscow]")
@Validated
@Tag(name = "student", description = "the students API")
public interface StudentApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /student : Метод создания студента
     *
     * @param student  (required)
     * @return Успешный ответ с созданным студентом (status code 200)
     *         or Неверное значение статуса (status code 400)
     *         or Всё нестандартное (status code 200)
     */
    @Operation(
        operationId = "create",
        summary = "Метод создания студента",
        tags = { "student" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ с созданным студентом", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Неверное значение статуса"),
            @ApiResponse(responseCode = "default", description = "Всё нестандартное", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/student",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<Student>> create(
        @Parameter(name = "Student", description = "", required = true) @Valid @RequestBody Student student
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"firstName\" : \"Ivan\", \"lastName\" : \"Ivanov\", \"middleName\" : \"Ivanovich\", \"id\" : 0, \"login\" : \"Ivan123\", \"age\" : 23 }, { \"firstName\" : \"Ivan\", \"lastName\" : \"Ivanov\", \"middleName\" : \"Ivanovich\", \"id\" : 0, \"login\" : \"Ivan123\", \"age\" : 23 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * DELETE /student/{student_id} : Удаление студента
     *
     * @param studentId Идентификатор студента (required)
     * @return Успешное удаление (status code 200)
     *         or Неверное значение статуса (status code 400)
     *         or Всё нестандартное (status code 200)
     */
    @Operation(
        operationId = "delete",
        summary = "Удаление студента",
        tags = { "student" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление"),
            @ApiResponse(responseCode = "400", description = "Неверное значение статуса"),
            @ApiResponse(responseCode = "default", description = "Всё нестандартное", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/student/{student_id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Void> delete(
        @Parameter(name = "student_id", description = "Идентификатор студента", required = true, in = ParameterIn.PATH) @PathVariable("student_id") String studentId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /student : Метод получения списка студентов
     *
     * @return Успешный ответ со списком студентов (status code 200)
     *         or Неверное значение статуса (status code 400)
     *         or Всё нестандартное (status code 200)
     */
    @Operation(
        operationId = "findAll",
        summary = "Метод получения списка студентов",
        tags = { "student" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ со списком студентов", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Неверное значение статуса"),
            @ApiResponse(responseCode = "default", description = "Всё нестандартное", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/student",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<List<Student>>> findAll(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ null, null ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /student/{student_id} : Метод получения студента по идентификатору
     *
     * @param studentId Идентификатор студента (required)
     * @return Успешный ответ с одним студентом (status code 200)
     *         or Неверное значение статуса (status code 400)
     *         or Всё нестандартное (status code 200)
     */
    @Operation(
        operationId = "findById",
        summary = "Метод получения студента по идентификатору",
        tags = { "student" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ с одним студентом", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Неверное значение статуса"),
            @ApiResponse(responseCode = "default", description = "Всё нестандартное", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/student/{student_id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Student>> findById(
        @Parameter(name = "student_id", description = "Идентификатор студента", required = true, in = ParameterIn.PATH) @PathVariable("student_id") String studentId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"firstName\" : \"Ivan\", \"lastName\" : \"Ivanov\", \"middleName\" : \"Ivanovich\", \"id\" : 0, \"login\" : \"Ivan123\", \"age\" : 23 }, { \"firstName\" : \"Ivan\", \"lastName\" : \"Ivanov\", \"middleName\" : \"Ivanovich\", \"id\" : 0, \"login\" : \"Ivan123\", \"age\" : 23 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
