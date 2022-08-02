package com.example.viedos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viedos.adapter.RecyclerViewAdapter
import com.example.viedos.databinding.ListFragmentBinding
import com.example.viedos.di.VideoViewModelAssistedFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VideosListFragment : Fragment() {

    @Inject
    lateinit var assistedFactory: VideoViewModelAssistedFactory
    private val viewModel: VideoViewModel by viewModels { assistedFactory.create(this) }
    private val binding by lazy { ListFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        viewModel.videos.observe(viewLifecycleOwner) { videos ->
            val recyclerViewAdapter = RecyclerViewAdapter(videos)
            binding.recyclerView.adapter = recyclerViewAdapter
            recyclerViewAdapter.onItemClick = {
                val navigation =
                    VideosListFragmentDirections.actionVideosListToVideoFragment(it.sources[0])
                findNavController().navigate(navigation)
                viewModel.addVideoInfo(
                    actionType = ACTION_PLAY,
                    titleVideo = it.title,
                )
            }
        }
        return binding.root
    }

    companion object {
        const val ACTION_PLAY = "play"
    }
}
