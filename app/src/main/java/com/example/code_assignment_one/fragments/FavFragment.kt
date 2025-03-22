package com.example.code_assignment_one.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.code_assignment_one.databinding.FragmentFavBinding


/* a fragment is a reusable Ui that can be used
multiple times, here I am extending a fragment
class so it can be used in the activity by saying
"FavFragment: Fragment()",   A fragment is basically a mini activity */

class FavFragment: androidx.fragment.app.Fragment() {

    /*this null declaration is to hold reference to the
fragments views after the fragment has been destroyed*/
    private var bindingNull: FragmentFavBinding? = null

    // this is a getter for binding, it will be used to access the views
    // !! will make sure it is not null
    private val binding get() = bindingNull!!


    // we will call this method at the time the fragment is being created
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // This gets the fragment back to the original state, then allows us to view it.
        bindingNull = FragmentFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

   // we use this when we are onDestroy so
   // we can clean up the resources that are related to the fragments view
    override fun onDestroyView() {
        super.onDestroyView()
        // Set the binding to null to clean as part of the function
        bindingNull = null
    }
}