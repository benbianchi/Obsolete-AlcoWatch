package edu.wpi.alcowatch.alcowatch.Classification;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomTree;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 * Created by ben on 2/5/17.
 */

public class ClassificationHelper {
    public static ClassificationHelper createClassificationHelper(Classifier classifier, File ToClassify)
    {

        return new ClassificationHelper(classifier, ToClassify);
    }

    private ClassificationHelper(Classifier c, File ToClassify)
    {



    }
}
