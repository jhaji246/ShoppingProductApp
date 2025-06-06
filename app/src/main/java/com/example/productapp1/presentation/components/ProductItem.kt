package com.example.productapp1.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.productapp1.domain.model.Product

@Composable
fun ProductItem(modifier: Modifier, product: Product) {

    Column(
        modifier = modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(elevation = CardDefaults.cardElevation(8.dp), shape = RoundedCornerShape(8.dp)) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = product.image, contentDescription = "",
                    modifier = modifier.fillMaxWidth().padding(4.dp).clip(RoundedCornerShape(4.dp))
                )
                Text(text = product.title, fontWeight = FontWeight.Bold)
                Text(text = product.description)
                Spacer(modifier = modifier.padding(6.dp))
            }
        }
    }
}