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


    int start = 0;
    std::string str;
    std::cin >> str;

    int time = 0;
    for (char c : str) {
        int target = c - 'A';
        int clockwise = (target - start + 26) % 26;
        int counterclockwise = (start - target + 26) % 26;
        time += std::min(clockwise, counterclockwise);
        start = target;
	}

	std::cout << time << "\n";

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}