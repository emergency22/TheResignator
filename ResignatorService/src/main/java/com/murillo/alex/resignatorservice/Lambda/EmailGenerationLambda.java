package com.murillo.alex.resignatorservice.Lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.murillo.alex.resignatorservice.Activity.Requests.EmailGenerationRequest;
import com.murillo.alex.resignatorservice.Activity.Results.EmailGenerationResult;

public class EmailGenerationLambda extends LambdaActivityRunner<EmailGenerationRequest, EmailGenerationResult>
        implements RequestHandler<LambdaRequest<EmailGenerationRequest>, LambdaResponse> {

        @Override
        public LambdaResponse handleRequest(LambdaRequest<EmailGenerationRequest> input, Context context) {
            return super.runActivity(() -> input.fromBody(EmailGenerationRequest.class),
                    (request, serviceComponent) ->
                            serviceComponent.provideEmailGenerationActivity().handleRequest(request)
            );
        }
    }