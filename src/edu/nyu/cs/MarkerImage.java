
package edu.nyu.cs;

import processing.core.PApplet;
// used by marker
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import de.fhpotsdam.unfolding.marker.AbstractMarker;
import de.fhpotsdam.unfolding.geo.Location;

public class MarkerImage extends AbstractMarker {

	PApplet app;
	PImage img;
	public static final String MARKER_BLUE = "images/marker_blue.png"; 

	/**
	 * Construct a new Marker with a specific image to use as the marker.
	 * @param app A PApplet object.
	 * @param location A Location object indicating where to place the marker.
	 * @param imgPath A String containing the file path to the image to use as a marker.
	 */
	public MarkerImage(PApplet app, Location location, String imgPath) {
		super(location);
		this.app = app;
		this.img = app.loadImage(imgPath);
	}

	/**
	 * Construct a new Marker using the default marker image located at "images/marker_blue.png".
	 * @param app A PApplet object.
	 * @param location A Location object indicating where to place the marker.
	 */
	public MarkerImage(PApplet app, Location location) {
		this(app, location, MARKER_BLUE);
	}

	@Override
	public void draw(PGraphics pg, float x, float y) {
		pg.pushStyle();
		pg.imageMode(PConstants.CORNER);
		// The image is drawn in object coordinates, i.e. the marker's origin (0,0) is at its geo-location.
		pg.image(img, x - 11, y - 37);
		pg.popStyle();
	}

	@Override
	protected boolean isInside(float checkX, float checkY, float x, float y) {
		return checkX > x && checkX < x + img.width && checkY > y && checkY < y + img.height;
	}

} // MarkerImg
