package com.shop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.shop.R;
import com.shop.model.Shoes;

public class FragmentDetail extends Fragment {

    private ActionBar toolbar;
     Shoes shoes1 = null;

     private IClickAddToCartListener iClickAddToCartListener;
    public interface IClickAddToCartListener{
        void onClickAddtoCart(Shoes shoes);
    }
    public FragmentDetail() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Lấy thông tin đối tượng Shoes từ Bundle
        Bundle bundle = getArguments();
        Shoes shoes = (Shoes) bundle.getSerializable("shoes");
        shoes1 = shoes;

        // Hiển thị thông tin đối tượng Shoes lên màn hình
        ImageView imageView = view.findViewById(R.id.d_image);
        TextView nameTextView = view.findViewById(R.id.d_name);
        TextView priceTextView = view.findViewById(R.id.d_price);
        TextView bandTextView = view.findViewById(R.id.d_band);
        TextView describeTextView = view.findViewById(R.id.d_describe);
        String price ="Giá sản phẩm : "+ "$" + shoes.getPrice();
        imageView.setImageResource(shoes.getImage());
        nameTextView.setText(shoes.getName());
        priceTextView.setText(price);
        bandTextView.setText("Loại giày : "+shoes.getBrand());
        describeTextView.setText("Mô tả : "+shoes.getDescribe());

        MaterialTextView txtProductAmount = view.findViewById(R.id.txt_product_amount);
        ImageView btnReduce = view.findViewById(R.id.btn_reduce);
        ImageView btnIncrease = view.findViewById(R.id.btn_increase);
        MaterialButton btnAddToCart = view.findViewById(R.id.btn_add_to_cart);

        int quantity = shoes.getQuantity();
        int[] amount = {0}; // khởi tạo một mảng chứa biến amount và gán giá trị ban đầu là 0

        btnReduce.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (amount[0] > 0) {
                    amount[0]--;
                    txtProductAmount.setText(String.valueOf(amount[0]));
                    shoes.setQuantity(amount[0]);
                }
            }
        });

        // Xử lý sự kiện khi người dùng nhấn vào nút tăng
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if(amount[0] < quantity){
                    amount[0]++;
                    txtProductAmount.setText(String.valueOf(amount[0]));
                    shoes.setQuantity(amount[0]);
                }
            }
        });

        // Xử lý sự kiện khi người dùng nhấn vào nút thêm sản phẩm vào giỏ hàng
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (amount[0] > 0) {
                    Toast.makeText(getContext(), "Sản phẩm đã được thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                    shoes.setQuantity(quantity - amount[0]);
                    shoes.setAmount(amount[0]);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("shoes", shoes1);

                    Fragment fragment = new FragmentCart();
                    fragment.setArguments(bundle);

                    BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.navigation);
                    bottomNavigationView.setSelectedItemId(R.id.mCart);

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            }
        });

        return view;
    }

}

