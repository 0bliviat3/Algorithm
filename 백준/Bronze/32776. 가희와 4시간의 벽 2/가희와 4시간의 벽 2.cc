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

    int rail;
	std::cin >> rail;

    int a, b, c;
	std::cin >> a >> b >> c;
	int fly = a + b + c;

    if (rail <= 240 || rail <= fly) {
        std::cout << "high speed rail";
        return;
    }
    std::cout << "flight";
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}