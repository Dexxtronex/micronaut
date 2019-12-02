package io.micronaut.docs.server.upload;

// tag::class[]
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.multipart.CompletedPart;
import io.micronaut.http.server.multipart.MultipartBody;
import io.reactivex.Single;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Controller("/upload")
public class WholeBodyUploadController {

    @Post(value = "/whole-body", consumes = MediaType.MULTIPART_FORM_DATA) // <1>
    public Single<String> uploadBytes(@Body MultipartBody body) { // <2>
        return Single.create(emitter -> {
            body.subscribe(new Subscriber<CompletedPart>() {
                private Subscription s;

                @Override
                public void onSubscribe(Subscription s) {
                    this.s = s;
                    s.request(1);
                }

                @Override
                public void onNext(CompletedPart completedPart) {
                    String partName = completedPart.getName();
                    if (completedPart instanceof CompletedFileUpload) {
                        String originalFileName = ((CompletedFileUpload) completedPart).getFilename();
                    }
                }

                @Override
                public void onError(Throwable t) {
                    emitter.onError(t);
                }

                @Override
                public void onComplete() {
                    emitter.onSuccess("Uploaded");
                }
            });
        });
    }
}
// end::class[]
