package org.apache.maven.surefire.its;


import junit.framework.TestCase;
import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

import java.io.File;

/**
 * Test 
 * 
 * @author <a href="mailto:dfabulich@apache.org">Dan Fabulich</a>
 * 
 */
public class TimeoutForkedTest
    extends TestCase
{
    public void testTimeoutForked ()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/timeout-forked" );

        Verifier verifier = new Verifier( testDir.getAbsolutePath() );

        try {
            verifier.executeGoal( "test" );
            verifier.verifyErrorFreeLog();
            fail( "Build didn't fail, but it should have" );
        } catch (VerificationException e) 
        {
            // as expected
        }
        finally
        {
            verifier.resetStreams();
        }
        
    }
}