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

	double r, g, b;
	std::cin >> r >> g >> b;

	r /= 255.0;
	g /= 255.0;
	b /= 255.0;

	double k = 1 - std::max({ r, g, b });
	if (k == 1) {
		std::cout << "0 0 0 1\n";
		return;
	}

	double c = (1 - r - k) / (1 - k);
	double m = (1 - g - k) / (1 - k);
	double y = (1 - b - k) / (1 - k);

	std::cout << std::fixed << std::setprecision(6) << c << " " << m << " " << y << " " << k << "\n";


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}