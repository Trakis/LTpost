/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opt.ltpost.model;

import opt.ltpost.model.views.LayoutRootView;
import opt.ltpost.model.views.PostLabelsSignView;
import java.io.IOException;

/**
 * SINGLETON Open/Re-open views
 *
 * @author gbruzgys
 */
public class ViewManager {

    private static ViewManager instance = null;

    private LayoutRootView rootView = null;

    private ViewManager() {
        try {
            rootView = LayoutRootView.getInstance();
            rootView.show();
        } catch (IOException ex) {
            ex.printStackTrace();          
        }
    }

    public static synchronized ViewManager getInstance() {
        if (instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }

    /**
     * show Post Labels Sign View
     *
     * @throws IOException
     */
    public void showPostLabelSignView() throws IOException {

        rootView.SetVisibleView(PostLabelsSignView.getInstance().getViewNode());

    }

}
