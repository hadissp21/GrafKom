#version 330

out vec4 fragColor;
uniform vec4 uni_color;
void main(){
    //vec4(red, green, blue, alpha)
    //rgba -> red 100/255
    //fragColor = vec4(1.0f, 0.0f, 0.0f, 1.0f);
    fragColor = uni_color;
}