package com.example.code_assignment_one.fragments

import android.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.zip.Inflater


/* a fragment is a reusable Ui that can be used
multiple times, here I am extending a fragment
class so it can be used in the activity by saying
"FavFragment: Fragment()" */

class FavFragment: Fragment() {

/*this null declaration is to hold reference to the
fragments views after the fragment has been destroyed*/
    private var bindingNull: FragmentFavBinding? = null

    // this is a getter for binding, it will be used to access the views
    // !! will make sure it is not null
    private val binding get() = bindingNull!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
savedInstanceState: Bund
        )
}