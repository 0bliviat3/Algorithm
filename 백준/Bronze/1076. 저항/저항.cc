#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

    std::unordered_map<std::string, int> color_map = {
        {"black", 0},
        {"brown", 1},
        {"red", 2},
        {"orange", 3},
        {"yellow", 4},
        {"green", 5},
        {"blue", 6},
        {"violet", 7},
        {"grey", 8},
        {"white", 9}
	};

    std::string color1, color2, color3;
    std::cin >> color1 >> color2 >> color3;
    long long value = (color_map[color1] * 10 + color_map[color2]) * std::pow(10, color_map[color3]);
	std::cout << value << "\n";

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}