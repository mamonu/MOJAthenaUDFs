package com.awssupport.athena.udfs;

import com.amazonaws.athena.connector.lambda.handlers.UserDefinedFunctionHandler;
import com.amazonaws.athena.connector.lambda.security.CachableSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClient;

import com.google.common.annotations.VisibleForTesting;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;


import org.apache.commons.text.similarity.*;
import org.apache.commons.codec.language.*;

public class MOJAthenaUserDefinedFunctions
        extends UserDefinedFunctionHandler
{
    private static final String SOURCE_TYPE = "MinistryOfJustice";

    public MOJAthenaUserDefinedFunctions()
    {
        super(SOURCE_TYPE);
    }

    public static int levenshteinDistance(String left, String right) {

        LevenshteinDistance levenshtein = new LevenshteinDistance();
        Integer result = levenshtein.apply(left, right);

        return result;
    }

    public static double jaroWinklerDistance(String left, String right) {

        JaroWinklerDistance jaro = new JaroWinklerDistance();
        Double result = jaro.apply(left, right);

        return result;
    }


    public static String dm(String inp) {

        DoubleMetaphone dm = new DoubleMetaphone();
        String result = dm.encode(inp);

        return result;
    }


}
