import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import java.awt.image.BufferedImage;
import javax.media.j3d.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

public final class energon2 extends JPanel {
    int s = 0, count = 0;

    public energon2() {

        setLayout(new BorderLayout());
        GraphicsConfiguration gc=SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(gc);
        add("Center", canvas3D);

        BranchGroup scene = createSceneGraph();
        scene.compile();

        // SimpleUniverse is a Convenience Utility class
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);


        // This moves the ViewPlatform back a bit so the
        // objects in the scene can be viewed.
        simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.addBranchGraph(scene);
        
    }
    public BranchGroup createSceneGraph() {
        BranchGroup lineGroup = new BranchGroup();
        Appearance app = new Appearance();

        QuadArray lsa = new QuadArray(48,QuadArray.COORDINATES|QuadArray.NORMALS);
        Vector3f [] normals=new Vector3f[24];
        for(int i=0;i<24;i++)normals[i]=new Vector3f();
        Point3f [] pts=new Point3f[24];
        for(int i=0;i<24;i++)pts[i]=new Point3f();
        Color3f [] clrs=new Color3f[24];
        for(int i=0;i<24;i++)clrs[i]=new Color3f(0.5f,0.5f,0.5f);
        //cube=6 quads 
        //first quad
        pts[0].x=0f;pts[0].y=0f;pts[0].z=1.5f;
        pts[1].x=0f;pts[1].y=0.3f;pts[1].z=1.5f;
        pts[2].x=1.5f;pts[2].y=0.3f;pts[2].z=1.5f;
        pts[3].x=1.5f;pts[3].y=0f;pts[3].z=1.5f;
        normals[0].x=-1;normals[1].x=-1;normals[2].x=-1;normals[3].x=-1;
        //second quad
        pts[4].x=0f;pts[4].y=0f;pts[4].z=1.5f;
        pts[5].x=0f;pts[5].y=0.3f;pts[5].z=1.5f;
        pts[6].x=1.5f;pts[6].y=0.3f;pts[6].z=1.5f;
        pts[7].x=1.5f;pts[7].y=0f;pts[7].z=1.5f;
        normals[4].x=1;normals[5].x=1;normals[6].x=1;normals[7].x=1;

        //third quad
        pts[8].x=0f;pts[8].y=0f;pts[8].z=1.5f;
        pts[9].x=0f;pts[9].y=0.3f;pts[9].z=1.5f;
        pts[10].x=1.5f;pts[10].y=0.3f;pts[10].z=1.5f;
        pts[11].x=1.5f;pts[11].y=0f;pts[11].z=1.5f;
        normals[8].z=-1;normals[9].z=-1;normals[10].z=-1;normals[11].z=-1;
        //fourth quad
        pts[12].x=0f;pts[12].y=0f;pts[12].z=1.5f;
        pts[13].x=0f;pts[13].y=0.3f;pts[13].z=1.5f;
        pts[14].x=1.5f;pts[14].y=0.3f;pts[14].z=1.5f;
        pts[15].x=1.5f;pts[15].y=0f;pts[15].z=1.5f;
        normals[12].z=1;normals[13].z=1;normals[14].z=1;normals[15].z=1;
        //fifth quad
        pts[16].x=0f;pts[16].y=0f;pts[16].z=1.5f;
        pts[17].x=0f;pts[17].y=0.3f;pts[17].z=1.5f;
        pts[18].x=1.5f;pts[18].y=0.3f;pts[18].z=1.5f;
        pts[19].x=1.5f;pts[19].y=0f;pts[19].z=1.5f;
        normals[16].y=-1;normals[17].y=-1;normals[18].y=-1;normals[19].y=-1;
        //sixth quad
        pts[20].x=0f;pts[20].y=0f;pts[20].z=1.5f;
        pts[21].x=0f;pts[21].y=0.3f;pts[21].z=1.5f;
        pts[22].x=1.5f;pts[22].y=0.3f;pts[22].z=1.5f;
        pts[23].x=1.5f;pts[23].y=0f;pts[23].z=1.5f;
        normals[20].y=1;normals[21].y=1;normals[22].y=1;normals[23].y=1;
        lsa.setNormals(0, normals);
        lsa.setCoordinates(0, pts);
        Shape3D sh=new Shape3D();
        PolygonAttributes pa=new PolygonAttributes();
        pa.setPolygonMode(PolygonAttributes.POLYGON_FILL);
        pa.setCullFace(PolygonAttributes.CULL_NONE);
        Material mat=new Material();
        mat.setEmissiveColor(new Color3f(0.5f,0.5f,0.5f));
        mat.setAmbientColor(new Color3f(0.1f,0.1f,0.1f));
        mat.setDiffuseColor(new Color3f(0.2f,0.3f,0.4f));
        mat.setSpecularColor(new Color3f(0.6f,0.3f,0.2f));
        mat.setLightingEnable(true);
        RenderingAttributes ra=new RenderingAttributes();
        ra.setIgnoreVertexColors(true);
        ColoringAttributes ca=new ColoringAttributes();
        ca.setShadeModel(ColoringAttributes.SHADE_GOURAUD);
        ca.setColor(new Color3f(0.2f,0.5f,0.9f));
        app.setColoringAttributes(ca);
        app.setRenderingAttributes(ra);   
        app.setMaterial(mat);
        app.setPolygonAttributes(pa);
        sh.setGeometry(lsa);
        sh.setAppearance(app);
        sh.setPickable(true); 
        
        TransformGroup objRotate = new TransformGroup();
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.addChild(sh);
        
        TransformGroup tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        DirectionalLight light1=new DirectionalLight();
        light1.setInfluencingBounds(new BoundingSphere(new Point3d(-5.0,0,0),10.0));
        light1.setColor(new Color3f(1f,1f,1f));
        light1.setDirection(new Vector3f(0,1,0));
        objRotate.addChild(light1);
        DirectionalLight light2=new DirectionalLight();
        light2.setInfluencingBounds(new BoundingSphere(new Point3d(5.0,0,0),10.0));
        light2.setColor(new Color3f(0.5f,1f,0.5f));
        light2.setDirection(new Vector3f(0,-1,0));
        objRotate.addChild(light2);
        MouseRotate f1=new MouseRotate();
        f1.setSchedulingBounds(new BoundingSphere());
        f1.setTransformGroup(objRotate);
        lineGroup.addChild(f1);
        ///Initialize and setup mouse zooming
        ///Note: use alt-click & dragging to zoom in/out
        MouseZoom mz = new MouseZoom();
        mz.setTransformGroup(objRotate);
        lineGroup.addChild(mz);
        mz.setSchedulingBounds(new BoundingSphere());
        ///Initialize and setup mouse translation
        ///Note: use right click dragging to move object
        MouseTranslate mt = new MouseTranslate();
        mt.setSchedulingBounds(new BoundingSphere(new Point3d(5.0,0,0),10.0));
        mt.setTransformGroup(objRotate);
        lineGroup.addChild(mt);
        
        ///setup mouse for pillar
        
        MouseRotate f11=new MouseRotate();
        f11.setSchedulingBounds(new BoundingSphere());
        f11.setTransformGroup(tg);
        lineGroup.addChild(f11);
        ///Initialize and setup mouse zooming
        ///Note: use alt-click & dragging to zoom in/out
        MouseZoom mz1 = new MouseZoom();
        mz1.setTransformGroup(tg);
        lineGroup.addChild(mz1);
        mz1.setSchedulingBounds(new BoundingSphere());
        ///Initialize and setup mouse translation
        ///Note: use right click dragging to move object
        MouseTranslate mt1 = new MouseTranslate();
        mt1.setSchedulingBounds(new BoundingSphere(new Point3d(5.0,0,0),10.0));
        mt1.setTransformGroup(tg);
        lineGroup.addChild(mt1);
        
        Appearance ap = new Appearance();
		//objRotate.addChild(new Sphere(0.60f,1,128));
        ///add stuff on temple here
        Cylinder pillar = new Cylinder(0.1f,0.5f, ap);
        Transform3D Transform = new Transform3D();
        Vector3f vector = new Vector3f(1f,-1f,-1f);
        Transform.setTranslation(normals[3]);
        tg.setTransform(Transform);
        tg.addChild(pillar);
        
        lineGroup.addChild(objRotate);
        lineGroup.addChild(tg);
        return lineGroup;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(new energon2()));
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}