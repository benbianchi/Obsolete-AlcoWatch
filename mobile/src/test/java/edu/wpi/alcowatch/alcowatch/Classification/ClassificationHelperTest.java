package edu.wpi.alcowatch.alcowatch.Classification;

/**
 * Created by ben on 2/5/17.
 */

import org.junit.Test;


import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;

import weka.classifiers.trees.J48;

import weka.core.Instances;

import weka.core.converters.ConverterUtils;


/**
 * Todo:
 * Classification Via J19
 * Classifciaion Via RandomForest
 *
 */

public class ClassificationHelperTest {

    @Test
    public void setup() {

    }

    @Test
    public void classifyAsZeroBAC() {


        try {


            Instances i = ConverterUtils.DataSource.read("/home/ben/Development/wpi/MQP/AlcoWatch/resources/test.arff");
            i.setClassIndex(i.numAttributes()-1);
            Classifier cls = (J48) weka.core.SerializationHelper.read("/home/ben/Development/wpi/MQP/AlcoWatch/resources/Model/j48.model");





            Evaluation eTest = new Evaluation(i);
            eTest.evaluateModel(cls, i);

            System.out.println(eTest.toClassDetailsString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
