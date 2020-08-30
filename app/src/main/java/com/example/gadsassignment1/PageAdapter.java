package com.example.gadsassignment1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numTabs;
    /**
     * Constructor for {@link FragmentPagerAdapter} that sets the fragment manager for the adapter.
     * This is the equivalent of calling {@link #//FragmentPagerAdapter(FragmentManager, int)} and
     * passing in {@link #BEHAVIOR_SET_USER_VISIBLE_HINT}.
     *
     * <p>Fragments will have {@link Fragment#setUserVisibleHint(boolean)} called whenever the
     * current Fragment changes.</p>
     *
     * @param fm fragment manager that will interact with this adapter
     * @deprecated use {@link #//FragmentPagerAdapter(FragmentManager, int)} with
     * {@link #BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT}
     */
    public PageAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            return  new TopLearnersFragment();
            case 1:
                return  new TopIQSkillsFragment();

            default:
                return null;
        }
        /*return null;*/
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return numTabs;
    }

    /**
     * Called when the host view is attempting to determine if an item's position
     * has changed. Returns {@link #POSITION_UNCHANGED} if the position of the given
     * item has not changed or {@link #POSITION_NONE} if the item is no longer present
     * in the adapter.
     *
     * <p>The default implementation assumes that items will never
     * change position and always returns {@link #POSITION_UNCHANGED}.
     *
     * @param object Object representing an item, previously returned by a call to
     *               {@link #//instantiateItem(View, int)}.
     * @return object's new position index from [0, {@link #getCount()}),
     * {@link #POSITION_UNCHANGED} if the object's position has not changed,
     * or {@link #POSITION_NONE} if the item is no longer present.
     */
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE /*super.getItemPosition(object)*/;
    }
}
